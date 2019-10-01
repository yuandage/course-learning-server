package yh.base.service;

import yh.base.dao.LabelDao;
import yh.base.entity.Label;
import yh.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    public void save(Label label) {
        label.setId(idWorker.nextId()+"");//设置分布式ID
        labelDao.save(label);
    }

    public void update(Label label) {
        labelDao.save(label);
    }

    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    //第一种方法,有点麻烦
//    public List<Label> findSearch(Label label) {
//        return labelDao.findAll((Specification<Label>) (root, query, cb) -> {
//            /**
//             * @param root 根对象,条件封装到那个对象中, where 字段 = label.getId
//             * @param query 封装查询关键字,如group by, order by等
//             * @param cb 封装条件对象,直接返回null,表示不需要任何条件
//             * @return
//             */
//            List<Predicate> list = new ArrayList<>();//存放所有的查询条件
//            if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
//                Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");//labelname like "%PHP%"
//                list.add(predicate);
//            }
//            if (label.getState() != null && !"".equals(label.getState())) {
//                Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());//state = "1"
//                list.add(predicate);
//            }
//            Predicate[] predicateArray = new Predicate[list.size()];
//            list.toArray(predicateArray);
//            return cb.and(predicateArray);//where labelname like "%PHP%" and //state = "1"
//
//        });
//    }

    //第二种方法
    public List<Label> findSearch(Label label) {
        return labelDao.findByLabelNameLikeAndState("%"+label.getLabelName()+"%",label.getState());
    }

    public Page<Label> pageQuery(Label label, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        return labelDao.findByLabelNameLikeAndState("%"+label.getLabelName()+"%",label.getState(), pageable);
//        return labelDao.findAll((Specification<Label>) (root, query, cb) -> {
//            List<Predicate> list = new ArrayList<>();//存放所有的查询条件
//            if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
//                Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");//labelname like "%PHP%"
//                list.add(predicate);
//            }
//            if (label.getState() != null && !"".equals(label.getState())) {
//                Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());//state = "1"
//                list.add(predicate);
//            }
//            Predicate[] predicateArray = new Predicate[list.size()];
//            list.toArray(predicateArray);
//            return cb.and(predicateArray);//where labelname like "%PHP%" and //state = "1"
//        }, pageable);
    }
}
