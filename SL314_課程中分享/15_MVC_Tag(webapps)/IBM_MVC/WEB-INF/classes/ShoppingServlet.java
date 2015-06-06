import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import shopping.BOOK;

public class ShoppingServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		// res.setContentType("text/html; charset=UTF-8");
		// PrintWriter out = res.getWriter();

		HttpSession session = req.getSession();
		Vector<BOOK> buylist = (Vector<BOOK>) session.getAttribute("shoppingcart");
		String action = req.getParameter("action");

		if (!action.equals("CHECKOUT")) {

			// 刪除購物車中的書籍
			if (action.equals("DELETE")) {
				String del = req.getParameter("del");
				int d = Integer.parseInt(del);
				buylist.removeElementAt(d);
			}
			// 新增書籍至購物車中
			else if (action.equals("ADD")) {
				boolean match = false;

				// 取得後來新增的書籍
				BOOK abook = getBook(req);

				// 新增第一本書籍至購物車時
				if (buylist == null) {
					buylist = new Vector<BOOK>();
					buylist.add(abook);
				} else {
					for (int i = 0; i < buylist.size(); i++) {
						BOOK book = buylist.get(i);

						// 假若新增的書籍和購物車的書籍一樣時
						if (book.getName().equals(abook.getName())) {
							book.setQuantity(book.getQuantity()
									+ abook.getQuantity());
							buylist.setElementAt(book, i);
							match = true;
						} // end of if name matches
					} // end of for

					// 假若新增的書籍和購物車的書籍不一樣時
					if (!match)
						buylist.add(abook);
				}
			}

			session.setAttribute("shoppingcart", buylist);
			String url = "/EShop.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}

		// 結帳，計算購物車書籍價錢總數
		else if (action.equals("CHECKOUT")) {
			float total = 0;
			for (int i = 0; i < buylist.size(); i++) {
				BOOK order = buylist.get(i);
				float price = order.getPrice();
				int quantity = order.getQuantity();
				total += (price * quantity);
			}

			String amount = String.valueOf(total);
			req.setAttribute("amount", amount);
			String url = "/Checkout.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}
	}

	private BOOK getBook(HttpServletRequest req) {

		String quantity = req.getParameter("quantity");
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		String price = req.getParameter("price");

		BOOK bk = new BOOK();

		bk.setName(name);
		bk.setAuthor(author);
		bk.setPublisher(publisher);
		bk.setPrice((new Float(price)).floatValue());
		bk.setQuantity((new Integer(quantity)).intValue());
		return bk;
	}
}
