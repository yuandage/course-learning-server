package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.CourseCategoryDao;
import yh.course.entity.CourseCategory;
import yh.util.IdWorker;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseCategoryService {
    @Autowired
    CourseCategoryDao courseCategoryDao;
    @Autowired
    private IdWorker idWorker;

    public List<CourseCategory> findAll() {
        return courseCategoryDao.findAll();
    }

    public CourseCategory findById(String id) {
        return courseCategoryDao.findById(id).orElse(null);
    }

    public List<CourseCategory> findByParentId(String parentId) {
        return courseCategoryDao.findByParentId(parentId);
    }

    public List<CourseCategory> findSubCategory() {
        return courseCategoryDao.findByParentIdNot("0");
    }

    public void save(CourseCategory courseCategory) {
        courseCategory.setId(idWorker.nextStringId());//设置分布式ID
        courseCategoryDao.save(courseCategory);
    }

    public void update(CourseCategory courseCategory) {
        courseCategoryDao.save(courseCategory);
    }

    public void deleteById(String id) {
        courseCategoryDao.deleteById(id);
    }

    //获取课程分类树
    public List<CourseCategory> findCourseCategory() {

        List<CourseCategory> list = courseCategoryDao.findAll();
        //根据父节点id分组
        Map<String, List<CourseCategory>> map = list.stream()
                .filter(o -> !Objects.equals(o.getParentId(), "0"))
                .collect(Collectors.groupingBy(CourseCategory::getParentId));

        //循环处理子节点 构建树状结构
        Iterator<CourseCategory> it = list.iterator();
        while (it.hasNext()) {
            CourseCategory courseCategory = it.next(); // next() 返回下一个元素
            if (map.containsKey(courseCategory.getId())) {
                courseCategory.setChildren(map.get(courseCategory.getId()));
            } else {
                it.remove(); // remove() 移除元素
            }
        }

        return list;//一级学科分类
    }

}
