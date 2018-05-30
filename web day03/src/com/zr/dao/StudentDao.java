package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zr.entity.Student;
import com.zr.utils.DBConnection;

/**
 * student���ݷ��ʶ���
 * 
 * @author Administrator
 * 
 */
public class StudentDao {

	/**
	 * ��ѯȫ��
	 * @return
	 */
	public List<Student> queryAll() {
		List<Student> list = new ArrayList<Student>(); 
		// 1.ȡ�����Ӷ���
		Connection conn = DBConnection.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from websites");
			// ִ��
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Student(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getInt(4), rs.getString(5)));
				System.out.print("ID: " + rs.getInt(1));
                System.out.print(", վ������: " + rs.getString(2));
                System.out.print(", վ�� URL: " + rs.getString(3));
                System.out.print("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs, ps, conn);
		}
		return list;
	}
	
	/**
	 * ����idɾ��
	 * @param id
	 */
	public void delById(int id){
		Connection conn = DBConnection.getConn();
		String sql = "delete from websites where id=?";
		PreparedStatement ps =null;
		try {
			ps = conn.prepareStatement(sql);
			//��������ֵ
			ps.setInt(1, id);
			// ִ��
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(null, ps, conn);
		}
	}
	public void insert(int id,String name,String url,int alexa,String country){
		Connection conn = DBConnection.getConn();
		String sql = "insert into websites values(?,?,?,?,?)";
		String sql2 = "update websites values(?,?,?,?,?) where id =?";
		String sql3 = "SELECT COUNT(*) FROM websites WHERE ID=?";
		PreparedStatement ps =null;
		PreparedStatement ps2 =null;	
		int count=0;
		try {
			ps2=conn.prepareStatement(sql3);
			ps2.setInt(1, id);
			ResultSet rs= ps2.executeQuery();
		/*	while(rs.next()){
				count++;
			}*/
		//	if(count==1){
				ps = conn.prepareStatement(sql);
			//��������ֵ
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, url);
			ps.setInt(4, alexa);
			ps.setString(5, country);
			// ִ��
			ps.executeUpdate();
		/*	}else{
				ps = conn.prepareStatement(sql2);
				//��������ֵ
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, url);
				ps.setInt(4, alexa);
				ps.setString(5, country);
				ps.setInt(6,id);
			}*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(null, ps, conn);
		}
	}
	public void chsert(int id,String name,String url,int alexa,String country){
		Connection conn = DBConnection.getConn();
		String sql = "insert into websites values(?,?,?,?,?)";
		String sql2 = "update websites set id=?,name=?,url=?,alexa=?,country=? where id =?";
		String sql3 = "SELECT COUNT(*) FROM websites WHERE ID=?";
		PreparedStatement ps =null;
		PreparedStatement ps1 =null;
		PreparedStatement ps2 =null;	
		int count=0;
		try {
			ps2=conn.prepareStatement(sql3);
			ps2.setInt(1, id);
			ResultSet rs= ps2.executeQuery();
			while(rs.next()){
				count++;
			}
			if(count==0){
				System.out.println("�����ڣ�");
				ps = conn.prepareStatement(sql);
			//��������ֵ
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, url);
			ps.setInt(4, alexa);
			ps.setString(5, country);
			// ִ��
			ps.executeUpdate();
			}else{
				System.out.println("���ڣ�");
				ps1 = conn.prepareStatement(sql2);
				//��������ֵ
				ps1.setInt(1, id);
				ps1.setString(2, name);
				ps1.setString(3, url);
				ps1.setInt(4, alexa);
				ps1.setString(5, country);
				ps1.setInt(6,id);
				ps1.executeUpdate();
			}
			count=0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(null, ps, conn);
		}
	}
	public List<Student> search(int id){
		List<Student> list = new ArrayList<Student>(); 
		// 1.ȡ�����Ӷ���
		Connection conn = DBConnection.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from websites where id = ?");
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Student(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getInt(4), rs.getString(5)));
				System.out.print("ID: " + rs.getInt(1));
                System.out.print(", վ������: " + rs.getString(2));
                System.out.print(", վ�� URL: " + rs.getString(3));
                System.out.print("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(null, ps, conn);
		}
		return list;
	}
}















