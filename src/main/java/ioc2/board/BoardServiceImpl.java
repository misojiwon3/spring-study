package ioc2.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 4. Service 구현 클래스
@Service("boardService")
public class BoardServiceImpl implements BoardService {
//	@Autowired
//	private BoardDAOSpring boardDAO;

    @Autowired
    private BoardDao boardDAO;

    public void insertBoard(BoardVO vo) {
        if (vo.getSeq() == 0) {
            throw new IllegalArgumentException("0번째 글은 등록할 수 없습니다.");
        }
        boardDAO.insertBoard(vo);
    }

    public void updateBoard(BoardVO vo) {
        boardDAO.updateBoard(vo);
    }

    public void deleteBoard(BoardVO vo) {
        boardDAO.deleteBoard(vo);
    }

    public BoardVO getBoard(BoardVO vo) {
        return boardDAO.getBoard(vo);
    }

    public List<BoardVO> getBoardList(BoardVO vo) {
        return boardDAO.getBoardList(vo);
    }

}
