package mvc.controller.board;


import mvc.business.board.BoardService;
import mvc.business.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	// XML
//	@RequestMapping("/transform.do")
//	@ResponseBody
//	public BoardListVO transform(BoardVO vo, BoardListVO boardListVO) {
//		boardListVO.setBoards(boardService.getBoardList(vo));
//		
//		return boardListVO;
//	}
	
	// JSON
	@RequestMapping("/transform.do")
	@ResponseBody
	public List<BoardVO> transform(BoardVO vo) {
		return boardService.getBoardList(vo);
	}
	
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public String insertBoardView(@ModelAttribute("board") BoardVO vo) {
		vo.setTitle("글 제목입니다");
		vo.setWriter("글쓴이");
		return "insertBoard";
	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws Exception {
		MultipartFile file = vo.getUploadFile();
		if (!file.isEmpty()) {
			file.transferTo(new File("C:/DEV/uploadedFile/" + file.getOriginalFilename()));
		}
		
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(int seq, BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}

	@RequestMapping(value="/getBoardList.do", method=RequestMethod.GET)
	public String getBoardList(BoardVO vo, Model model) {
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList";
	}
	
	@RequestMapping(value="/getBoardList.do", method=RequestMethod.POST)
	public String getBoardList(BoardVO vo, Model model, String searchCondition, String searchKeyword) {
		System.out.println("searchCondition : " + searchCondition);
		System.out.println("searchKeyword : " + searchKeyword);
		
		if (searchCondition.equals("TITLE")) {
			vo.setTitle(searchKeyword);
			System.out.println("v1o : " + vo);
		} else if (searchCondition.equals("CONTENT")) {
			vo.setContent(searchKeyword);
		} else {
			System.out.println("����?");
		}
		
		System.out.println("v2o : " + vo);
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList";
	}
}
