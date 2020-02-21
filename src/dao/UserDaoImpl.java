package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public int addUser(User user) {
		PreparedStatement ps=null;
		Connection conn=DBUtil.getConnection();
		String sql="INSERT INTO T_USER(USER_ID,USER_NAME,SEX) VALUES(SEQ_T_USER.NEXTVAL,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setInt(2, user.getSex());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConn(conn, ps, null);//查询才要用到结果集rs
		}
		
		
		return 0;
	}

	@Override
	public List<User> queryUsers(User user) {
		List<User> userList=new ArrayList<User>();//存数据
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="SELECT USER_ID,USER_NAME,SEX FROM T_USER WHERE 1=1";
		Connection conn=null;
		
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			if(user.getUserName()!=null &&!user.getUserName().equals("")) {
				sql+="AND USER_NAME LIKE ?";
				ps.setString(1, "'%"+user.getUserName()+"%'");
			}
			rs=ps.executeQuery();
			while(rs.next()) {
				int userId=rs.getInt("USER_ID");
				String userName=rs.getString("userName");
				int sex=rs.getInt("SEX");
				User temp=new User(userId,userName,sex);
				userList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConn(conn, ps, null);//查询才要用到结果集rs
		}
		return userList;
	}

}
