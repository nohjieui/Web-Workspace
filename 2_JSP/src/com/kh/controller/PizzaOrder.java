package com.kh.controller;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaOrder
 */
@WebServlet("/pizzaOrder2.do")
public class PizzaOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaOrder() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		// 요청시 전달된 값들은 request parameter영역에 담겨있음
		String pizza = request.getParameter("pizza");
		String[] toppings = request.getParameterValues("topping");
		String[] sides = request.getParameterValues("side");
		
		int price = 0;
		
		switch(pizza) {
		case "치즈피자" 	: price += 5000; break;
		case "콤비네이션피자" : price += 6000; break;
		case "포테이토피자"  :
		case "고구마피자"   : price += 7000; break;
		case "불고기피자"   : price += 8000; break;
		}
		
		if(toppings != null) {
			for(String topping : toppings) {
				switch(topping) {
				case "고구마무스"  : price += 1000; break;
				case "콘크림무스"  : price += 1500; break;
				case "파인애플토핑" : 
				case "치즈토핑"   : 
				case "치즈크러스트" : price += 2000; break;
				case "치즈바이트"  : price += 3000; break;
				}
			}
		}
		
		if(sides != null) {
			for(String side : sides) {
				switch(side) {
				case "오븐구이통닭"	 : price += 9000; break;
				case "치킨스틱&윙"	 : price += 4900; break;
				case "치즈오븐스파게티" : price += 4000; break;
				case "새우링&웨지감자" : price += 35000; break;
				case "갈릭포테이토"	 : price += 3000; break;
				case "콜라"		 :
				case "사이다"		 : price += 1500; break;
				case "갈릭소스"		 : price += 500; break;
				case "피클"		 : price += 300; break;
				case "핫소스"		 : 
				case "파마산치즈가루"  : price += 100; break;
				}
			}
		}
		
		// 응답페이지를 만드는 과정을 JSP에게 위임
		// 단, 그 응답화면(JSP)에서 필요로하는 데이터들을 request객체에 담아서 보내줘야함
		// request의 attribute영역에 담아서 보내줄 예정(key, value세트로)
		request.setAttribute("pizza", pizza);
		request.setAttribute("topping", toppings);
		request.setAttribute("side", sides);
		request.setAttribute("price", price);
		
		// 응답하고자하는 뷰(JSP)를 선택하면서 생성
		 RequestDispatcher view = request.getRequestDispatcher("views/PizzaPay.jsp");	
		
		view.forward(request,response);
	}

}
