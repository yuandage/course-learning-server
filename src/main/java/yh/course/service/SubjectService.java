package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.SubjectDao;
import yh.course.entity.Subject;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubjectService {
    @Autowired
    SubjectDao subjectDao;

    public List<Subject> findSubjectType() {

        List<Subject> list = subjectDao.findAll();
        //根据父节点id分组
        Map<Integer, List<Subject>> map = list.stream()
                .filter(o -> Objects.nonNull(o.getParentId()))
                .collect(Collectors.groupingBy(Subject::getParentId));

        //循环处理子节点 构建树状结构
        list.forEach(subject -> {
            if (map.containsKey(subject.getId())) {
                subject.setSubjectList(map.get(subject.getId()));
            }
        });

        //获取指定分类的对象
        //Subject result = list.stream().filter(subject -> subject.getId() == 1|| subject.getId() == 2).findFirst().orElse(null);

        return list.subList(0,5);
    }
}
