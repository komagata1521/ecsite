package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dao.UnsubscribeDAO;
import com.internousdev.ecsite.dto.UnsubscribeDTO;
import com.opensymphony.xwork2.ActionSupport;;

public class UnsubscribeConfirmAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private ArrayList<UnsubscribeDTO> confirmList = null;
	private MyPageDAO myPagedao = new MyPageDAO();
	private UnsubscribeDAO unSubscribedao = new UnsubscribeDAO();

	public String execute() throws SQLException {
//		削除失敗した場合にエラー画面へ遷移させるため初期値ERROR;
		String result = ERROR;
		String userId = session.get("login_user_id").toString();

//		ユーザー情報と購入履歴を削除する
		int count = unSubscribedao.deleteUserInfo(userId);
		int history = myPagedao.buyItemHistoryDelete(userId);

//		削除処理が実行された場合、処理が適切に完了しているか確かめるため当該ユーザーの履歴情報を取得してListに格納する
		if(count > 0 && history >= 0) {
			confirmList = unSubscribedao.infoDeleteConfirm(userId);
			System.out.println(confirmList.size());
		}else {
			result = ERROR;
		}

//		リストへの格納処理が実行されている、かつ、リストに情報が無いときユーザー情報削除が完了したとして、ログアウト処理を実行し、完了画面へ遷移する。
		if(!(confirmList == null) && confirmList.isEmpty()) {
			session.clear();
			result = SUCCESS;
		}else if(confirmList == null) {
			result = ERROR;
		}
		return result;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}