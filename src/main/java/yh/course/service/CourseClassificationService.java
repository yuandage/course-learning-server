package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.CourseClassificationDao;
import yh.course.entity.CourseClassification;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CourseClassificationService {
    @Autowired
    CourseClassificationDao courseClassificationDao;
	@Autowired
	private IdWorker idWorker;

	public List<CourseClassification> findAll() {
		return courseClassificationDao.findAll();
	}

	public CourseClassification findById(String id) {
		return courseClassificationDao.findById(id).orElse(null);
	}
	
	public List<CourseClassification> findByParentId(String parentId) {
		return courseClassificationDao.findByParentId(parentId);
	}

	public void save(CourseClassification courseClassification) {
		courseClassification.setId(idWorker.nextId() + "");//设置分布式ID
		courseClassificationDao.save(courseClassification);
	}

	public void update(CourseClassification courseClassification) {
		courseClassificationDao.save(courseClassification);
	}

	public void deleteById(String id) {
		courseClassificationDao.deleteById(id);
	}

    //已废弃
//    public List<CourseClassification> findSubjectType() {
//
//        List<CourseClassification> list = courseClassificationDao.findAll();
//        //根据父节点id分组
//        Map<Integer, List<CourseClassification>> map = list.stream()
//                .filter(o -> Objects.nonNull(o.getParentId()))
//                .collect(Collectors.groupingBy(CourseClassification::getParentId));
//
//        //循环处理子节点 构建树状结构
//        list.forEach(courseClassification -> {
//            if (map.containsKey(courseClassification.getId())) {
//                courseClassification.setCourseClassificationList(map.get(courseClassification.getId()));
//            }
//        });
//
//        //获取指定分类的对象
//        //Subject result = list.stream().filter(subject -> subject.getId() == 1|| subject.getId() == 2).findFirst().orElse(null);
//
//        //获取一级学科分类的数量subjectDao.countByParentIdIsNull()
//        return list.subList(0, courseClassificationDao.countByParentIdIsNull());//一级学科分类
//    }
//
//    public List<CourseClassification> findChildSubject() {
//        return courseClassificationDao.findByParentIdNotNull();
//    }


}
