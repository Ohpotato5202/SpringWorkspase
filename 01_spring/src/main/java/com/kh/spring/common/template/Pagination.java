package com.kh.spring.common.template;

import com.kh.spring.common.model.vo.PageInfo;

public class Pagination {

	public static PageInfo getPageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		
		/* 		===== maxPage =====
		 * (listCount와 boardLimit에 영향을 받음)
		 * 
		 * 		[공식 구하기] 
		 * (단, boardLimit값은 10이라는 가정하에 규칙을 세울 예정.)
		 * 
		 * 총 갯수		boardLimit		maxPage
		 *  100				10			  10번
		 *  101				10			  11번
		 *  ...				...			  11번
		 *  110				10			  11번
		 *  
		 *  111				10			  12번
		 *  
		 * 111.0/10 -> 11.1 -> 올림처리 -> 12.0 -> 소수점 제거 -> 12
		 */
		int maxPage = (int)(Math.ceil(((double)listCount/boardLimit)));
		
		/*		===== startPage =====
		 * (currentPage와 pageLimit에 영향을 받음)
		 * 
		 * 		[공식 구하기] 
		 * (단, pageLimit는 10이라는 가정으로 규칙 찾기)
		 * 
		 * startPage : 1, 11, 21, 31 ... -> n * 10 + 1
		 * 10은 pageLimit값이므로 => n * pageLimit + 1 
		 * 
		 * currentPage		startPage
		 * 		1				1 == n * pageLimit + 1 => n = 0
		 * 		...				1 == n * pageLimit + 1 => n = 0
		 * 	    10				1 == n * pageLimit + 1 => n = 0
		 * 
		 * 		11				11 == n * pageLimit + 1 => n = 1
		 * 		...				11
		 * 		20				11 == n * pageLimit + 1 => n = 1
		 * 		
		 * 	  1~10 => n=0
		 * 	  11~20 => n=1
		 * 	  21~30 => n=2
		 * 
		 * n = (currentPage - 1) / pageLimit 연산후 소수점 제거시 n의 값이 나옴
		 * startPage = n * pageLimit + 1
		 * startPage = (currentPage - 1) / pageLimit * pageLimit + 1
		 */
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1; 
		
		/*		===== endPage =====
		 * (startPage와 pageLimit에 영향을 받음)
		 * 
		 * 단, endPage가 maxPage를 넘어가면 endPage에 maxPage를 대입 
		 */
	    int endPage = startPage + pageLimit - 1;
	    
	    if(endPage > maxPage) {
	    	endPage = maxPage;
	    }
	    
	    PageInfo pageInfo = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
	    
	    return pageInfo;
	}
	
	
	
}


