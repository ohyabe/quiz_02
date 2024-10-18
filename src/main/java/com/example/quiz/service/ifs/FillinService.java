package com.example.quiz.service.ifs;

import com.example.quiz.vo.BasicRes;
import com.example.quiz.vo.FeedbackReq;
import com.example.quiz.vo.FeedbackRes;
import com.example.quiz.vo.FillinReq;
import com.example.quiz.vo.StatisticsRes;

public interface FillinService {
		// ��g����
		public BasicRes fillin(FillinReq req);
		// ���e���i�d�ݶ�g���᪺���
		public FeedbackRes feedback(FeedbackReq req);
		
		public StatisticsRes statistics(FeedbackReq req);

}
