package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {

	private final String command = "list.tv";
	private final String getPage = "travelList";

	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(
			@RequestParam(value = "whatColumn", required = false) String whatColumn,
	         @RequestParam(value = "keyword", required = false) String keyword,
	         @RequestParam(value = "pageNumber", required = false) String pageNumber,
	         HttpServletRequest request
			) {
		
		System.out.println("TLC pageNumber:" + pageNumber); 
		System.out.println("TLC doAction()");
		System.out.println("whatColumn : " + whatColumn); // area, style, null
		System.out.println("keyword : " + keyword); // ����, null
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		 
		int totalCount = travelDao.getTotalCount(map);//Ű���� ����
		String url = request.getContextPath() + "/" +  this.command;
		 
		Paging pageInfo = new Paging(pageNumber,null,totalCount,url,whatColumn,keyword);
		List<TravelBean> lists = travelDao.getTravelList(map, pageInfo); 
 
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("totalCount", totalCount);
		mav.setViewName(getPage);

		return mav;
	}
}




