package comt.tieunt.springboot;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import comt.tieunt.springboot.model.Todo;
import comt.tieunt.springboot.repository.TodoRepository;
import comt.tieunt.springboot.service.TodoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoServiceTest {
	/**
	 * Cách này sử dụng @SpringBootTest Nó sẽ load toàn bộ Bean trong app của bạn
	 * lên, Giống với việc chạy App.java vậy
	 */

	/**
	 * Đối tượng TodoRepository sẽ được mock, chứ không phải bean trong context
	 */
	@MockBean
	TodoRepository todoRepository;

	@Autowired
	private TodoService todoService;

	@Before
	public void setUp() {
		Mockito.when(todoRepository.findAll()).thenReturn(LongStream.range(0, 10)
				.mapToObj(i -> new Todo(i, "title-" + i, "detail-" + i)).collect(Collectors.toList()));
	}
	
	@Test
	public void testCount() {
		Assert.assertEquals(10, todoService.countTodo());
	}
}
