package mvc.board;

import mvc.business.board.BoardService;
import mvc.business.board.BoardVO;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {

	private ClassPathXmlApplicationContext container =
			new ClassPathXmlApplicationContext("business-layer.xml");

	private BoardService boardService =
			(BoardService) container.getBean("boardService");

	private BoardVO board = new BoardVO();


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

	@Test
	public void insertBoard() {
		board.setSeq(10);
		board.setTitle("제7목7");
		board.setWriter("9글7쓴이");
		board.setContent("0내8용");

		boardService.insertBoard(board);
		System.out.println("success to insert board");
	}

	@Test
	public void updateBoard() {
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		vo.setTitle("수정된 제목");
		vo.setWriter("수정된 글쓴이");
		vo.setContent("수정된 내용");

		boardService.updateBoard(vo);
		System.out.println("success to update board");
	}

	@Test
	public void deleteBoard() {
		BoardVO vo = new BoardVO();
		vo.setSeq(10);

		boardService.deleteBoard(vo);
		System.out.println("success to delete board");
	}

	@Test
	public void getBoard() {
		BoardVO vo = new BoardVO();
		vo.setSeq(4);

		boardService.getBoard(vo);
		System.out.println("success to get board");
	}

	@Test
	public void getBoardList() {
		BoardVO vo = new BoardVO();
		vo.setTitle("수");

		for (BoardVO board : boardService.getBoardList(vo)) {
			System.out.println("board : " + board.toString());
		}
		System.out.println("success to get board list");
	}
}
