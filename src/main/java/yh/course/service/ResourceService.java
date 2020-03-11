package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.ResourceDao;
import yh.course.entity.Resource;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class ResourceService {
	@Autowired
	private ResourceDao resourceDao;
	@Autowired
	private IdWorker idWorker;

	public List<Resource> findAll() {
		return resourceDao.findAll();
	}

	public Resource findById(String id) {
		return resourceDao.findById(id).orElse(null);
	}

	public void save(Resource resource) {
		resource.setId(idWorker.nextId() + "");//设置分布式ID
		resource.setResUrl("http://localhost:9000/resource/download/" + resource.getId());
		resourceDao.save(resource);
	}

	public void update(Resource resource) {
		resourceDao.save(resource);
	}

	public void deleteById(String id) {
		resourceDao.deleteById(id);
	}

	public List<Resource> findByCourseId(String courseId) {
		return resourceDao.findByCourseId(courseId);
	}
}
