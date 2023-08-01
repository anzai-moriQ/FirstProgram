package com.example.demo.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.Games;
import com.example.demo.Repository.GamesRepository;

@Controller
public class GameController {
	
	@Autowired
	GamesRepository gamesRepository;
	
	/**
	 * 退屈度ゲームメーカーの画面へ
	 * @param mv
	 * @return
	 */
	@RequestMapping("/game")
	public ModelAndView gameView(ModelAndView mv) 
	{
		mv.setViewName("game");
		return mv;
	}
	
	/**
	 * ランダムでゲーム情報を取得する画面
	 * @param grade
	 * @param mv
	 * @return
	 */
	@RequestMapping("/game/like")
	public ModelAndView likeGame(@RequestParam(name="grade")int grade,ModelAndView mv)
	{
		//リストを生成して選択された疲労度の中からランダムにゲーム名とキャプションを取得
		List<Games> gamesList = gamesRepository.findByGrade(grade);
		Random rand = new Random();
		int random = rand.nextInt(gamesList.size());
		String name = gamesList.get(random).getName();
		String caption = gamesList.get(random).getCaption();
		
		//ゲーム名とキャプションをセットしてgamelike,htmlへ
		mv.addObject("name", name);
		mv.addObject("caption", caption);
		mv.setViewName("gamelike");
		return mv;
	}
}
