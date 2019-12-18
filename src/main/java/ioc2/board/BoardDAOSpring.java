package ioc2.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// 2. DAO(Data Access Object) Class
@Repository("boardDAOSpring")
public class BoardDAOSpring implements BoardDao {
	
	@Autowired
	private JdbcTemplate springJdbc;

	// BOARD 테이블 관련 SQL 명령어들
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select ifnull(max(seq), 0) + 1 from board ALIAS_FOR_SUBQUERY),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";

	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC 기반으로 insertBoard() 처리");
		springJdbc.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC 기반으로 updateBoard() 처리");
		springJdbc.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC 기반으로 deleteBoard() 처리");
		springJdbc.update(BOARD_DELETE, vo.getSeq());
	}

	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC 기반으로 getBoard() 처리");
		BoardVO board = null;
		
		return board;
	}

	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC 기반으로 getBoardList() 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		return boardList;
	}
}
