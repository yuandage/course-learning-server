package yh.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CrudService {
	@Autowired
	private Dao dao;
	@Autowired
	private IdWorker idWorker;

	public List<Label> findAll() {
		return dao.findAll();
	}

	public Label findById(String id) {
		return dao.findById(id).orElse(null);
	}

	public void save(Label label) {
		label.setId(idWorker.nextStringId());//设置分布式ID
		dao.save(label);
	}

	public void update(Label label) {
		dao.save(label);
	}

	public void deleteById(String id) {
		dao.deleteById(id);
	}

}
