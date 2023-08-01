package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.Users;
import com.example.demo.Repository.UsersRepository;

@Controller
public class AccountController {
	@Autowired
	HttpSession session;

	@Autowired
	UsersRepository usersRepository;

	/**
	 * @param mv
	 * @return
	 */
	// 最初の画面（ログアウト時に戻ってくる場所）
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}

	/**
	 * ログインするところ
	 * @param name
	 * @param pass
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/top")
	public ModelAndView top(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "pass", defaultValue = "") String pass, ModelAndView mv) {
		// 未入力の場合
		if ("".equals(name) || "".equals(pass)) {
			// 画面に情報を受け渡し
			mv.addObject("message1", "登録情報に未入力の項目があります");
			// customer.htmlへ遷移
			mv.setViewName("index");
			return mv;
		}

		// DB内照合
		List<Users> usersList = usersRepository.findByNameAndPassword(name, pass);
		if (usersList != null && usersList.size() > 0) 
		{
			// セッションスコープにログイン時の名前を保存
			session.setAttribute("name", name);
			// top.html（トップ画面）へ
			mv.setViewName("top");
			return mv;
		}else 
		{
			//「 ユーザ名もパスワードもない」、「ユーザ名が無い」、「パスワードが無い」のどれかを判定
			mv.addObject("message2", "登録情報が間違っています");
			mv.setViewName("index");
			return mv;
		}
	}

	/**
	 * 新規登録画面の表示
	 * @param mv
	 * @return
	 */
	@RequestMapping("/newAccount")
	public ModelAndView newAccount(ModelAndView mv) {
		mv.setViewName("newaccount");
		return mv;
	}

	/**
	 * DBに登録して登録確認画面へ
	 * @param name
	 * @param pass
	 * @param mv
	 * @return
	 */
	@RequestMapping("/accountSet")
	public ModelAndView accountSet(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "pass", defaultValue = "") String pass, ModelAndView mv) {
		// 未入力の場合
		if ("".equals(name) || "".equals(pass)) {
			// 画面に情報を受け渡し
			mv.addObject("message3", "未入力の項目があります");
			mv.setViewName("newaccount");
			return mv;
		}

		// DB内で既に登録されているか照合(ユーザ名が使用されている)
		List<Users> usersNameList = usersRepository.findByName(name);
		if (usersNameList != null && usersNameList.size() > 0) {
			mv.addObject("message4", "このユーザー名はすでに使われています");
			mv.setViewName("newaccount");
			return mv;
		}

		// USERSテーブルへの登録
		Users users = new Users(name, pass);
		usersRepository.saveAndFlush(users);

		session.setAttribute("name", name);

		mv.addObject("name", name);
		mv.addObject("pass", pass);
		mv.setViewName("accountset");
		return mv;
	}

	/**
	 * 修正画面に飛ぶ
	 * @param name
	 * @param pass
	 * @param mv
	 * @return
	 */
	@RequestMapping("/update")
	public ModelAndView update(ModelAndView mv) {
		// 修正画面へ
		mv.setViewName("update");
		return mv;
	}

 /**
  * 登録情報の変更
  * @param name
  * @param pass
  * @param mv
  * @return
  */
	@RequestMapping("/update/return")
	public ModelAndView updateReturn(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "pass", defaultValue = "") String pass, ModelAndView mv) {

		//未入力
		if ("".equals(name) || "".equals(pass)) {
			// 画面に情報を受け渡し
			mv.addObject("empty", "未入力の項目があります");
			mv.setViewName("update");
			return mv;
		}
		
		// DB内で既に登録されているか照合(ユーザ名が使用されている)
		List<Users> usersNameList = usersRepository.findByName(name);
		if (usersNameList != null && usersNameList.size() > 0) {
			mv.addObject("already", "このユーザー名は情報はすでに使われています");
			mv.setViewName("update");
			return mv;
		}

		//ユーザーテーブルに修正時に入力された情報を上書きで更新する
		List<Users> usersList = usersRepository.findAll();
		Integer code = usersList.get(usersList.size() - 1).getCode();

		Users users = new Users(code, name, pass);
		usersRepository.saveAndFlush(users);

		mv.addObject("OK", "変更しました");
		mv.setViewName("update");
		return mv;
	}

	/**
	 * ログイン画面以外からtop画面（メイン）に直接ログインする
	 * @param mv
	 * @return
	 */
	@RequestMapping("/top/login")
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("top");
		return mv;
	}
}
