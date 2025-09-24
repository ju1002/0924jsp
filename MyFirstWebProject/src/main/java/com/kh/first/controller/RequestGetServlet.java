package com.kh.first.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//매핑값은 서블릿마다 고유한 값이어야함
/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/get.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestGetServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("와우");
		/*톰캣 실행 => web.xml 파싱(해석)
		 * 추상 메소드의 종류 
		 * init()=> service()=> doGet()/doPost()=>destroy()
		 * 서블릿 생명주기/싱글톤 패턴으로 객체하나만을 사용 / 톰캣이 멀티스레드 처리(스레드풀)
		 * 서블릿 만들면 딱 두 메소드만 만드는데 doGet과 doPost만 만듬
		 */
		
		/*Dynamic WebProject진행 시 Servlet을 Conteoller로 사용
		 * Controller하는 일 : 데이터 가공, 요청처리(서비스 호출) , 결과값 반환(응답화면 지정)
		 * 서블릿에서는 요청이 오면 가공하는 작업을 해줘야 함
		 * 
		 * 
		 * 
		 * View에서 Get방식으로 요청 시 doGet()가 호출됨
		 *
		 *인자값으로 두 새 넘어옴
		 *첫 번째 매개변수 HttpServletRequest 타입에는 요청 시 전달된 내용들이 담김
		 *->요청 전송 방식,요청 url,요청한 사용자의 정보,사용자가 input요소에 입력한 값 등
		 *
		 *두번째 매개변수 HttpServletResponse타입은 요청처리 후 응답할 때 사용하는 객체
		 *
		 *요청처리 과정
		 *1. 우선 요청을 처리하기위해서 요청 시 전달된 값(사용자가 입력한 값)들을 뽑는다.
		 *사용자가 전달한 자료형은 key-value세트로 담겨있음(name속성값 = value속성값)
		 *=> request의 Parameter라는 곳에서 전달값을 뽑아내야 함
		 *
		 *2. 뽑아낸 값을 가공해서 요청 처리를 진행해야함 (Service-> DAO->DB)
		 *
		 *3.처리결과에 따른 성공/ 실패 페이지 응담
		 * 
		 */
		
		
		/*request의 Parameter영역으로부터 전달된 데이터값을 뽑아내는 방법
		 * -request.getParameter("키값") : String(input요소에 적어놓은 name속성값 
		 * 이렇게 request에게 parameter를 내놔해야함
		 * 
		 * =>반환형이 String이기 때문에  다른 자료형으로 넘어온다면 알아서 parsing(해석)해야함
		 * 
		 * request.getParameterValuer("키값") : String[]
		 * => 하나의 key값으로 여러개의 value들을 받아야 할 경우
		 * 
		 * 먼저 내가 input요소의 내가 name을 어떤이름으로 했는지 알아야 함
		 */
		System.out.println("Get방식으로 호출됨");
//1단계 값 뽑기
		//반환 타입은 항상 스트링임 
		//input요소에 입력한 name value값을 가져와 보자
		String name = request.getParameter("name");
		System.out.println(name);
//name으로 올 수 있는  값은 셀 수 없다.
//텍스트 상자에 없으면 빈 문자열이 온다/null
		String gender= request.getParameter("gender");
		System.out.println(gender);
//gender로 넘어 올 수 있는값  : 남 , 여 , 선택안함, null
		//int age=request.getParameter("age");
		//parameter는 스트링 타이입어서 int가 올 수 없다
		int age=Integer.parseInt(request.getParameter("age"));
		System.out.println(age);
		//때문에 타입을 바꿔야 함
		String city = request.getParameter("city");
				System.out.println(city);
		
		double height = Double.parseDouble(request.getParameter("height"));
		//double 소수점 까지 나타내는 자료형
		System.out.println(height);
//	double형인데 int형을 바꿔줘야 함
		int realHeight=(int)height;
//	강제 형변환이 이루어짐
		
		String[] foods = request.getParameterValues("food");
		System.out.println(Arrays.toString(foods));
		
		//자주보는 상태코드
		//404: 파일 또는 요청을 받아주는 서블릿을 찾지 못했을 때 발생
//					=>  경로를 잘 못 적었거나,파일명에 오타가 났을 때
		//500: 자바 소스코드상의 오류 (예외 발생)
		/*2단계 데이터 가공
		 * Person person = new Person(name,  gender, age,city,height,fodds)
		 *만들었다 침
		 *
		 *3단계 요청처리(DB와의 상호작용==JDBC/MyBatis)
		 *보통의 흐름 : Controller에서 Service의 메소드를 호출하면 값을 전달
		 *DAO호출-> DB SQL문(INSERT)실행 -> 정수 형태의 결과값 반환
		 *int result = new PersonService().savePerson(person)
		 *실제로 값을 받았으면 이런걸 했겠지 ? 했다고 치
		 *
		 *4단계 결과값 반환 ore 응답화면 지정
		 *무조건 성공했다고 가정
		 *
		 *순수 Servlet만 사용해서 응답데이터 넘기기
		 *사용자에게 HTML+CSS_JS응답
		 *
		 *어떤식으로 받을꺼냐
		 *
		 *요청처리에 성공했습니다
		 *xxx님은 
		 *xx살이며,
		 *xxx에 삽니다.
		 *키는 xxxcm이고
		 *성별은 case1. 선택을 안했습니다.
		 *	   case2. 남성입니다.
		 *	   case3 . 여성입니다
		 *좋아하는 음식 case1. 없습니다.
		 * 	 		case2. 치킨 떡볶이~~~
		 */
		//응답해보자
		//1. 응답 데이터 형식 지정 -> 문서 형태의HTML/ 인코딩 방식 UTF-8
		response.setContentType("text/html; charset=UTF-8"); 
		//응답을 세팅을 먼저 해야 함 때문에 response에 참조 해서 set
		//2. 출력 스트림 생성
		//스트림을 통해 내보내야하는데 문자열 데이터들이 잇으니까
		// 스트림은 입출력 할 때 사용함
		//어떤 스트림 inputStream/ outputStream  영어 특수문자
		//            Reader / Writer		  한글이 껴있으
		//WriteStream으로 내보내야 함
		PrintWriter pw = response.getWriter();
		
		//3. 스트림을 이용해서 HTML데이터 출력
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title> 순수 서블릿으로 응답해보기 </title>");
		pw.println("<style>");
		
		pw.println("#name{color: orange}");
		pw.println("#age{color:orangered}");
		pw.println("#city{color: forestgreen}");
		pw.println("#height{color: green}");
		pw.println("#gender{color: gold}");
		
		pw.println("</style>");
		pw.println("</head>");
		
		pw.println("<body>");
		
			pw.println("<h1> 요청 처리에 성공했습니다 .<h1>");
			pw.printf("<span id='name'>$s</span> 님은 <br>",name);
			pw.printf("<span id= 'age'> %d </span> 살이며, <br>",age);
			pw.printf("<span id='city' > %s</span> 에 삽니다<br>", city);
		
			pw.printf("키는 <span id='height'>%.1f</span>cm이고 <br><br>", height);
			
			pw.print("성별은 ");
			if(gender==null||"선택안함".equals(gender)) {
				pw.println("선택을 안했습니다");
			}else if(gender.equals("남")) {
				pw.println("<span id='gender'>남자 </span>입니다");
			
			}else {
				pw.println("<span id='gender'>여자</span>입니다.");
			}
			
			
			pw.print("좋아하는 음식은");
			if(foods==null) {
				pw.println("없습니다.");
			}else {
				//선택한게 한개 이상인데 몇개인지 모르니까 반복
				//반복을 선택하는 이유 : 동일한 작업을 반복 1부터 10까지 출려을 할 때 출력을 반복해야하니까
				// 배열,리스트등 컬렉션능 순회할 때 학생 성적 목록을 출력 할 때
				//특정 조건을 만족할 때 까지 만족할 때  
				pw.println("<ul>");
				for(int i =0; i<foods.length; i++) {
					pw.printf("<li style='color:\"plum\"'>%s</li>",foods[i]);
				}
				pw.println("</ul>");
				pw.println("입니다.");
			}
			pw.println("<script>");
				pw.println("alert('축하해~~')");
			pw.println("</script>");
			
		pw.println("</body>");
		
		pw.println("</html>");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
 	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
