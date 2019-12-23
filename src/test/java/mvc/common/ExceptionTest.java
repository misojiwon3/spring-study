package mvc.common;

import mvc.business.board.BoardService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExceptionTest {

    private ClassPathXmlApplicationContext container =
            new ClassPathXmlApplicationContext("business-layer.xml");

    @Test(expected = NullPointerException.class)
    public void throwException() {
        BoardService boardService = (BoardService) container.getBean("boardService");
        boardService.getBoardList(null);
    }
}
