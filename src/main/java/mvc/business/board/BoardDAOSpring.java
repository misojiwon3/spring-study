package mvc.business.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

// 2. DAO(Data Access Object) Class
public class BoardDAOSpring implements BoardDAO {
	@Autowired
	private JdbcTemplate spring;

	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select ifnull(max(seq), 0) + 1 from board ALIAS_FOR_SUBQUERY),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_LIST_TITLE = "select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_CONTENT = "select * from board where content like '%'||?||'%' order by seq desc";

	public void insertBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 insertBoard() 처리");
		spring.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 updateBoard() 처리");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 deleteBoard() 처리");
		spring.update(BOARD_DELETE, vo.getSeq());
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 getBoard() 처리");
		Object[] args = {vo.getSeq()};
		return spring.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 getBoardList() 처리 : " + vo);

		if (vo.getTitle() != null) {
			Object[] args = {vo.getTitle()};
			return spring.query(BOARD_LIST_TITLE, args, new BoardRowMapper());
		} else if (vo.getContent() != null || vo.getContent().equals("")) {
			Object[] args = {vo.getContent()};
			return spring.query(BOARD_LIST_CONTENT, args, new BoardRowMapper());
		} else {
			return spring.query(BOARD_LIST, new BoardRowMapper());
		}
	}
}









