package com.example.demo.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.Saying;
import com.example.demo.Repository.SayingRepository;

@Controller
public class SayingController {
	
	@Autowired
	SayingRepository sayingRepository;
	
	@RequestMapping("/saying")
	public ModelAndView sayingView(ModelAndView mv) 
	{		
		//sayingテーブルからランダムに言葉を取得
		List<Saying> sayingList = sayingRepository.findAll();
		Random rand = new Random();
		int random = rand.nextInt(sayingList.size());
		String word = sayingList.get(random).getWord();

		//上で取得した言葉のgrade（レコード）を取得
		String grade = sayingList.get(random).getGrade();

		//画面say.htmlへ
		mv.addObject("word", word);
		mv.addObject("grade", grade);
		mv.setViewName("say");
		return mv;
	}
}
		
