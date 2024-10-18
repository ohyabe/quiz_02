package com.example.quiz.service.ifs;

import com.example.quiz.vo.BasicRes;
import com.example.quiz.vo.FeedbackReq;
import com.example.quiz.vo.FeedbackRes;
import com.example.quiz.vo.FillinReq;
import com.example.quiz.vo.StatisticsRes;

public interface FillinService {
		// 填寫答案
		public BasicRes fillin(FillinReq req);
		// 按前往可查看填寫完後的資料
		public FeedbackRes feedback(FeedbackReq req);
		
		public StatisticsRes statistics(FeedbackReq req);

}
