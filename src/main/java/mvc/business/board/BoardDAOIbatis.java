package mvc.business.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

// 2. DAO(Data Access Object) Class
public class BoardDAOIbatis implements BoardDAO {
	@Autowired
	private SqlMapClientTemplate iBatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> iBatis 기반으로 insertBoard() 처리");
		iBatis.insert("insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> iBatis 기반으로 updateBoard() 처리");
		iBatis.update("updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> iBatis 기반으로 deleteBoard() 처리");
		iBatis.update("deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> iBatis 기반으로 getBoard() 처리");
		return (BoardVO) iBatis.queryForObject("getBoard", vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> iBatis 기반으로 getBoardList() 처리 : " + vo);

		return iBatis.queryForList("getBoardList", vo);
		
		/*if (vo.getTitle() != null || vo.getTitle() == "") {
			Object[] args = {vo.getTitle()};
			return spring.query(BOARD_LIST_TITLE, args, new BoardRowMapper());
		} else if (vo.getContent() != null || vo.getContent() == "") {
			Object[] args = {vo.getContent()};
			return spring.query(BOARD_LIST_CONTENT, args, new BoardRowMapper());
		} else {
			return spring.query(BOARD_LIST, new BoardRowMapper());
		}*/
	}
}









