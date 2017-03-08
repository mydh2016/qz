package com.qazit.sysmanager.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qazit.sysmanager.util.ListUtils;
import com.qazit.sysmanager.util.StaticValue;
import com.qazit.sysmanager.web.dao.mapper.RolePermissionMapper;
import com.qazit.sysmanager.web.dao.mapper.VResourceMapper;
import com.qazit.sysmanager.web.model.RolePermission;
import com.qazit.sysmanager.web.model.RolePermissionExample;
import com.qazit.sysmanager.web.model.RolePermissionKey;
import com.qazit.sysmanager.web.model.VResource;
import com.qazit.sysmanager.web.model.VResourceExample;
import com.qazit.sysmanager.web.security.UserSessionOperator;
import com.qazit.sysmanager.web.service.IResourceService;
import com.qazit.sysmanager.web.service.IRoleService;

@Service
public class ResourceServiceImpl implements IResourceService {
	@Resource
	private VResourceMapper resourceMapper;
	@Resource
	private RolePermissionMapper rolePermissionMapper;
	@Resource
	private IRoleService roleServiceImpl;

	@Override
	public List<VResource> getResourcesByTypeId(int resourceTypeId) {
		List<VResource> resultList = new ArrayList<VResource>();
		//菜单暂时分为两类，一类是亚信安全平台的超级管理员，另一类是渠道商的菜单。
		//这两类数据是作为基础数据存放在菜单资源表中的
		String hospitalId = String.valueOf(UserSessionOperator.getCurrentHospitalId());
		if(!StaticValue.SUPER_HOSPITAL_ID.toString().equals(hospitalId)){
			hospitalId= StaticValue.HOSPITAL_DEFAULT_ID;//如果不是超级管理员，则试用默认的菜单
		}
		VResourceExample example = new VResourceExample();
		example.setOrderByClause("sortnum");
		example.createCriteria().andResourcetypeidEqualTo(resourceTypeId).andHospitalIdEqualTo(hospitalId);
		//根据HospitalId查找
		resultList = resourceMapper.selectByExample(example);
		return resultList;
	}

	@Override
	public List<VResource> getTreeMenuNodes(int resourcetTypeId){
		//获得该用户所属的HospitalId下的所有的菜单列表
		List<VResource> allList = this.getResourcesByTypeId(resourcetTypeId);
		
		List<VResource> rootResourceList = new ArrayList<VResource>();
		for (VResource vr : allList) {
			if (vr.getParentresourceid() == 0) {
				//找该父菜单下的子菜单
				List<VResource> listAllChildren = new ArrayList<VResource>();
				for(VResource childVR:allList){
					if(childVR.getParentresourceid()==vr.getResourceid()){
						listAllChildren.add(childVR);
					}
				}
				vr.setChildren(listAllChildren);
				rootResourceList.add(vr);
			}
		}
		return rootResourceList;
	}
	
	
	@Override
	public List<VResource> getTreeMenuNodesForIndex(int resourcetTypeId) {
		List<VResource> allList = new ArrayList<VResource>();
		if(UserSessionOperator.isAdmin()){
			//如果是管理员查询所有数据
			allList=this.getResourcesByTypeId(resourcetTypeId);
		}else{
			//菜单暂时分为两类，一类是亚信安全平台的超级管理员，另一类是渠道商的菜单。
			//这两类数据是作为基础数据存放在菜单资源表中的
			String hospitalId = String.valueOf(UserSessionOperator.getCurrentHospitalId());
			if(!StaticValue.SUPER_HOSPITAL_ID.equals(hospitalId)){//不是运营平台的，就是渠道商的
				hospitalId= StaticValue.HOSPITAL_DEFAULT_ID;
			}
			long userId = UserSessionOperator.getCurrentUserId();
			Map map = new HashMap();
			map.put("userId", userId);
			map.put("resourcetTypeId", resourcetTypeId);
			map.put("HospitalId", hospitalId);
			allList = resourceMapper.getTreeMenuNodesForIndex(map);
		}
		
		List<VResource> rootResourceList = new ArrayList<VResource>();
		for (VResource vr : allList) {
			if (vr.getParentresourceid() == 0) {
				//找该父菜单下的子菜单
				List<VResource> listAllChildren = new ArrayList<VResource>();
				for(VResource childVR:allList){
					if(childVR.getParentresourceid()==vr.getResourceid()){
						listAllChildren.add(childVR);
					}
				}
				vr.setChildren(listAllChildren);
				rootResourceList.add(vr);
			}
		}
		return rootResourceList;
	}
	
	@Override
	public List<VResource> getTreeMenuNodesByRoleId(int resourcetTypeId,int roleId) {
		
		//获得该用户所属的HospitalId下的所有的菜单列表
		List<VResource> allList = this.getResourcesByTypeId(resourcetTypeId);
		
		List<Integer> selectPermission = new ArrayList<Integer>();
		if (resourcetTypeId != 0 && roleId != 0) {
			selectPermission = roleServiceImpl.selectPermissionIdsByRoleIdAndResType(roleId,resourcetTypeId);
		}

		List<VResource> rootResourceList = new ArrayList<VResource>();
		for (VResource vr : allList) {
			if (vr.getParentresourceid() == 0) {
				if (selectPermission.contains(vr.getResourceid())) {
					vr.setCheck(true);
				}
				//找该父菜单下的子菜单
				List<VResource> listAllChildren = new ArrayList<VResource>();
				for(VResource childVR:allList){
					if(childVR.getParentresourceid()==vr.getResourceid()){
						if (selectPermission.contains(childVR.getResourceid())) {
							childVR.setCheck(true);
						}
						listAllChildren.add(childVR);
					}
				}
				vr.setChildren(listAllChildren);
				rootResourceList.add(vr);
			}
		}
		return rootResourceList;
	}

	public List<VResource> getRolePermissions(int roleId, int resourceTypeId) {
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRoleIdEqualTo(roleId)
				.andResourceTypeIdEqualTo(resourceTypeId);
		List<RolePermission> list = rolePermissionMapper.selectByExample(example);
		if (list == null || list.isEmpty()) {
			return null;
		}
		List<VResource> resultList = new ArrayList<VResource>();
		for (RolePermissionKey key : list) {
			VResourceExample e = new VResourceExample();
			e.createCriteria().andResourceidEqualTo(key.getResourceId())
					.andResourcetypeidEqualTo(key.getResourceTypeId());
			List<VResource> li = resourceMapper.selectByExample(e);
			if (li == null || li.isEmpty())
				continue;
			resultList.addAll(li);
		}
		return ListUtils.removeDuplication(resultList, "resourceid",
				"resourcetypeid");
	}

}
