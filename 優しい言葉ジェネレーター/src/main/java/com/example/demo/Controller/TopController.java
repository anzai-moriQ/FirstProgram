package com.example.demo.Controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.Words;
import com.example.demo.Repository.WordsRepository;

@Controller
public class TopController {

	@Autowired
	HttpSession session;

	@Autowired
	WordsRepository wordsRepository;

	/**
	 * ランダムで優しい言葉を表示
	 * @param stress
	 * @param mv
	 * @return
	 */
	@RequestMapping("/top/resultword")
	public ModelAndView word(@RequestParam("stress") int stress, ModelAndView mv)
	{
		//入力された疲労度と同じDB内のstress値の言葉を一つ取得
		List<Words> stressList = wordsRepository.findByStress(stress);
		Random rand = new Random();
		String word = stressList.get(rand.nextInt(stressList.size())).getWord();
		mv.addObject("word", word);
		mv.setViewName("resultword");
		return mv;
	}

	/**
	 * 新規登録の画面を表示する
	 * @param mv
	 * @return
	 */
	@RequestMapping("/addword")
	public ModelAndView addWord(ModelAndView mv) 
	{
		//利用者が言葉を登録する画面へ
		mv.setViewName("addword");
		return mv;
	}
	
	/**
	 * 	入力された言葉と疲労度を受け取って登録
	 * @param word
	 * @param stress
	 * @param mv
	 * @return
	 */
	@RequestMapping("/wordset")
	public ModelAndView wordset(
			@RequestParam(name="word", defaultValue = "" )String word,
			@RequestParam("stress")int stress,
			ModelAndView mv) 
	{
		//入力された文字が空文字かどうかチェック
		if(word == null || word.length() == 0) 
		{
			mv.addObject("error1", "未入力です。");
			mv.setViewName("addword");
			return mv;
		}
		//入力された言葉がDB内の言葉とかぶっていないかチェック
		List<Words> wordsList = wordsRepository.findByWord(word);
		if(wordsList != null && wordsList.size() > 0) 
		{
			mv.addObject("error2", "この言葉はすでに登録されています。");
			mv.setViewName("addword");
			return mv;
		}
		//入力された言葉と疲労度をDBに登録
		Words words = new Words(stress, word);
		wordsRepository.save(words);
		
		//入力された言葉と疲労度をwordset.htmlに送る
		mv.addObject("word", word);
		mv.addObject("stress", stress);
		mv.setViewName("wordset");	
		return mv;
	}
}
