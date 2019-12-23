package ioc2.board;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너 구동
		ClassPathXmlApplicationContext container = 
			new ClassPathXmlApplicationContext("business-layer.xml");
		
		// 테스트할 BoardService 타입의 객체 Lookup
		BoardService boardService =
			(BoardService) container.getBean("boardService");
		
		// 3. 검색한 객체 테스트
		BoardVO vo = new BoardVO();
		vo.setSeq(10);
		vo.setTitle("제목");
		vo.setWriter("글쓴이");
		vo.setContent("내용");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
