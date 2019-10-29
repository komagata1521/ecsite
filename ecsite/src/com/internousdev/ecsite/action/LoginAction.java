package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
//	ログイン画面でのフォームに対応したフィールドを定義
	private String loginUserId;
	private String loginPassword;
//	sessionをMap型で定義
	private Map<String, Object> session;
//	LodinDAOをインスタンス化
	private LoginDAO loginDAO = new LoginDAO();
//	LoginDTOをインスタンス化
	private LoginDTO loginDTO = new LoginDTO();
//	BuyItemDAOをインスタンス化
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute() {
//		戻り値の初期値をERRORに設定
		String result = ERROR;
//		loginDAOクラスのgetLoginInfoメソッドを実行、パラメータにloginUserId,loginPasswordを指定
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
//		loginDTOにKey「loginUser」を付与してsessionに格納
		session.put("loginUser", loginDTO);

//		if文:sessionからkey-loginUserの値を取得し,LoginDTO型に変換し、loginDTOクラスのgetLoginFlgメソッドを実行,loginFlgの値が真なら実行
		if(((LoginDTO) session.get("loginUser")).getLoginFlg())	{
//			戻り値の値をSUCCESSに書き換える(struts.xmlで定義した遷移先を指定
			result = SUCCESS;
//			BuyItemDTO型buyItemDTOにbuyItemDAOクラスのgetBuyItemメソッドの実行結果を代入
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
//			loginDTOクラスのgetLoginIdメソッドを実行、結果にkey-login_user_idを付与してsessionに格納＊＊＊
			session.put("login_user_id", loginDTO.getLoginId());
//			buyItemDTOクラスのgetIdメソッドを実行、結果にkey-idを付与してsessionに格納
			session.put("id", buyItemDTO.getId());
//			buyItemDTOクラスのgetItemNameメソッドを実行、結果にkey-buyItem_nameを付与してsesssionに格納
			session.put("buyItem_name", buyItemDTO.getItemName());
//			buyItemDTOクラスのgetItemPriceメソッドを実行、結果にkey-buyItem_priceを付与してsessionに格納
			session.put("buyItem_price", buyItemDTO.getItemPrice());
//			戻り値resultを返す
			return result;
		}
		return result;
	}
//	呼び出し元にloginUserIdの値を渡す
	public String getLoginUserId() {
		return loginUserId;
	}
//	このクラスのloginUserIdにloginUserIdの値を格納する
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
