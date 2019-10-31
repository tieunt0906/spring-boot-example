package comt.tieunt.springboot.util;

import java.util.Optional;

import org.thymeleaf.util.StringUtils;

import comt.tieunt.springboot.model.ErrorMessage;
import comt.tieunt.springboot.model.Todo;

public class TodoValidator {
	/**
     * Kiểm tra một object Todo có hợp lệ không
     * @param todo
     * @return
     */
	public boolean isValid(Todo todo) {
		return Optional.ofNullable(todo).filter(t -> !StringUtils.isEmpty(t.getTitle()))
				.filter(t -> !StringUtils.isEmpty(todo.getDetail())).isPresent();
	}
}
