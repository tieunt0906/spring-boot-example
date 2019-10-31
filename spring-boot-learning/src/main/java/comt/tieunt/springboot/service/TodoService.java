package comt.tieunt.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import comt.tieunt.springboot.model.Todo;
import comt.tieunt.springboot.repository.TodoRepository;
import comt.tieunt.springboot.util.TodoValidator;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private TodoValidator validator;

	/**
	 * Lấy ra danh sách List<Todo>
	 *
	 * @param limit - Giới hạn số lượng lấy ra
	 *
	 * @return Trả về danh sách List<Todo> dựa theo limit, nếu limit == null thì trả
	 *         findAll()
	 */

	public List<Todo> findAll(Integer limit) {
		return Optional.ofNullable(limit).map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
				.orElseGet(() -> todoRepository.findAll());
	}

	/**
	 * Thêm một Todo mới vào danh sách công việc cần làm
	 *
	 * @return Trả về đối tượng Todo sau khi lưu vào DB, trả về null nếu không thành
	 *         công
	 */
	public Todo addTodo(Todo todo) {
		if (validator.isValid(todo)) {
			return todoRepository.save(todo);
		}
		return null;
	}

	public int countTodo() {
		return todoRepository.findAll().size();
	}
}
