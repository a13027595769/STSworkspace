package com.mypack.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypack.dao.CartDaoIF;
import com.mypack.dao.CartDaoImpl;
import com.mypack.entity.Goods;
import com.mypack.entity.Item;
import com.mypack.entity.User;
import com.mysql.fabric.xmlrpc.base.Data;

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ȡ��Ʒ��ź���Ʒ��������
		HttpSession session=request.getSession();
		Goods ids=(Goods)session.getAttribute("good");
		int goodsId=ids.getGoodsId();
		
		String amount=request.getParameter("amount");
		int nums=Integer.parseInt(amount);//��Ʒ����
		
		
		String xj=request.getParameter("xiaoji");
		Double xiaoji=Double.parseDouble(xj);
		String zj=request.getParameter("zongji");
		Double zongji=Double.parseDouble(zj);
	
		//ȡ�û���
		String username=(String)request.getSession().getAttribute("name");
		
		//��װ��Item��������
		Goods good=new Goods();
		good.setGoodsId(goodsId);
		
		//User user=new User();
		//user.setUsername(username);
		
		Item item=new Item(good, nums, xiaoji, zongji);
		
		//��ӵ�cart
		CartDaoIF cartDao=new CartDaoImpl();
		boolean flag=cartDao.addCart(item);
		
		//�ж��Ƿ���ӳɹ�
		if(flag){
			response.sendRedirect("ListCartServlet");
		}else{
			response.sendRedirect("goodsDetail.jsp");
		}
		
		
		
	}

}
