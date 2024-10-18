package com.example.quiz.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.quiz.constants.OptionType;
import com.example.quiz.constants.ResMessage;
import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizDao;
import com.example.quiz.service.ifs.QuizService;
import com.example.quiz.vo.BasicRes;
import com.example.quiz.vo.CreateOrUpdateReq;
import com.example.quiz.vo.DeleteReq;
import com.example.quiz.vo.FillinReq;
import com.example.quiz.vo.Question;
import com.example.quiz.vo.SearchReq;
import com.example.quiz.vo.SearchRes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service // �O�o���[
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizDao quizDao;

	@Override
	public BasicRes createOrUpdate(CreateOrUpdateReq req) {
		// 1.�ˬd�Ѽ�
		BasicRes checkResult = checkParams(req);
		// checkReault == null �ɡA��ܰѼ��ˬd�����T
		if (checkResult != null) {
			return checkResult;
		}
//		//==================
//		if (checkResult.getStatusCode() == 200) {
//			
//		}
		// �]�� Quiz ���� questions ����Ʈ榡�O String�A�ҥH�n�N req �� List<Question> �ন String
		// �z�L ObjectMapper�i�H�⪫��(���O)�ন JSON �˦����r��
		ObjectMapper mapper = new ObjectMapper();
		try {
			String questionStr = mapper.writeValueAsString(req.getQuestionsList());
			// �Y�ϥ� if else �A�U��]�ݭn�A���@���A�é�b if �W��
//			Quiz quiz = new Quiz(req.getName(), req.getDescription(), req.getStartDate(), //
//					req.getEndDate(), questionStr, req.isPublished());
			// �Y req �� id > 0�A��ܧ�s�w�s�b����ơF�Y id= 0 �F�h��ܭn�s�W
			if (req.getId() > 0) {

				// �H�U��ؤ覡�ܤ@
				// �ϥΤ�k1�A�z�L findById �A�Y����ơA�N�|�^�Ǥ@�㵧�����
				// �ϥΤ�k2�A�]���O�z�L existsById �ӧP�_��ƬO�_�s�b�A�ҥH�^�Ǫ���ƥû����u�|�O�@�� bit(0 �� 1)
				// �覡1. �z�L findById: �Y����ơA�^�Ǿ㵧���

//				Optional<Quiz> op = quizDao.findById(req.getId());
//				// �P�_�O�_�����
//				if (op.isEmpty()) {
//					return new BasicRes(ResMessage.UPDATE_ID_NOT_FOUND.getCode(), //
//							ResMessage.UPDATE_ID_NOT_FOUND.getMessage());
//				}
//				Quiz quiz = op.get();// ���X�ӴN�� id
//				// �]�w�s��(�ȱq req ��)
//				// �N req �����s�ȳ]�w���ª� Quiz ���A���]�w id �A�]�� id �@��(�]�����쥻�����)
//				quiz.setName(req.getName());
//				quiz.setDescription(req.getDescription());
//				quiz.setStartDate(req.getStartDate());
//				quiz.setEndDate(req.getEndDate());
//				quiz.setQuestions(questionStr);
//				quiz.setPublished(req.isPublished());
				// ��k2. �z�L existsById: �^�Ǥ@�� bit ����
				// �o�A�n�P�_�q req �a�i�Ӫ� id �O�_�u�����s�b�� DB ��
				// �]���Y id ���s�b�A�S���ˬd�A����{���X�b�I�s JPA �� save ��k�ɡA�|�ܦ��s�W
				boolean boo = quizDao.existsById(req.getId());// id �O�_�s�b�A���s�b JPA �|�s�W
				if (!boo) {// !boo ��ܸ�Ƥ��s�b
					return new BasicRes(ResMessage.UPDATE_ID_NOT_FOUND.getCode(), //
							ResMessage.UPDATE_ID_NOT_FOUND.getMessage());
				}
				// �n�� id ��i�h
//				 �覡2: �]���O new �@�ӷs�� Quiz�A�ҥH�n�� id ��i�h(new �@�ӷs��)
////				quiz.setId(req.getId()); //
//				Quiz quiz = new Quiz(req.getId(),req.getName(), req.getDescription(), req.getStartDate(), //
//						req.getEndDate(), questionStr,req.isPublished());
			}
			// ==============================================
			// �W�z�@��q if �{���X�i�H�Y��H�U�o�q
//			if (req.getId() > 0 && !quizDao.existsById(req.getId())) {
//				return new BasicRes(ResMessage.UPDATE_ID_NOT_FOUND.getCode(),
//						ResMessage.UPDATE_ID_NOT_FOUND.getMessage());
//			}
			// ==============================================
//			Quiz quiz = new Quiz(req.getName(), req.getDescription(), req.getStartDate(), //
//					req.getEndDate(), questionStr,req.isPublished());
//			quizDao.save(quiz);
			// �]���ܼ� quiz �u�ϥΤ@���A�]���i�H�ϥΰΦW���O�覡���g(���ݭn�ܼ�)
//			quizDao.save(quiz);
			// new Quiz() ���a�J req.getId()�OPK�A�b�Isave�ɡA�|���h�ˬdPK �O�_���s�b��DB���A
			// �Y�s�b --> ��s�F���s�b --> �s�W
			// req ���S�������ɡA�w�]�O 0 �A�]�� id ����ƫ��A�O int
			quizDao.save(new Quiz(req.getId(), req.getName(), req.getDescription(), req.getStartDate(), //
					req.getEndDate(), questionStr, req.isPublished()));
		} catch (JsonProcessingException e) {
			return new BasicRes(ResMessage.JSON_PROCESSING_EXCEPTION.getCode(), //
					ResMessage.JSON_PROCESSING_EXCEPTION.getMessage());
		}
		return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
	}

	private BasicRes checkParams(CreateOrUpdateReq req) {
		// �ˬd�ݨ��Ѽ�
		// StringUtils.hasText(�r��): �|�ˬd�r��O�_�� null�B�Ŧr��B���ťզr��A�Y�O�ŦX3�ب䤤�@���A�|�^ false�A�O�h�^��
		// true
		// �e���[����ĸ���ܤϦV���N��A�Y�r�ꪺ�ˬd���G�O false ���ܡA�N�|�i�� if ����@�϶�
		// !StringUtils.hasText(req.getName()) ���P�� StringUtils.hasText((req.getName())
		// == false
		// ����ĸ� �S��ĸ�
		if (!StringUtils.hasText(req.getName())) {
			return new BasicRes(ResMessage.PARAM_QUIZ_NAME_ERROR.getCode(), ResMessage.PARAM_QUIZ_NAME_ERROR.getMessage());
		}
		if (!StringUtils.hasText(req.getDescription())) {
			return new BasicRes(ResMessage.PARAM_DESCRIPTION_ERROR.getCode(),
					ResMessage.PARAM_DESCRIPTION_ERROR.getMessage());
		}
//		// �}�l�ɶ�����b����(�t)���e�A���Ѫ��ɶ��O�ڹq�����ɶ�
//		// LocalDate.now(): ���o�t�η�e�ɶ�
//		// req.getStartDate().isBefore(LocalDate.now()): �Y req �����}�l�ɶ�"��"���e�ɶ��A�|�o�� true
//		// req.getStartDate().isEqual(LocalDate.now()): �Y req �����}�l�ɶ�"��"���e�ɶ��A�|�o�� true
//		// �]���}�l�ɶ�����b����(�t)���e�A�ҥH�W��Ӥ���Y�O���@�ӵ��G�� true�A�h��ܶ}�l�ɶ��n���e(�t)�ɶ���
//		if (req.getStartDate() == null || req.getStartDate().isBefore(LocalDate.now()) // 
//				|| req.getStartDate().isEqual(LocalDate.now())) {
//			return new BasicRes(ResMessage.PARAM_START_DATE_ERROR.getCode(),
//					ResMessage.PARAM_START_DATE_ERROR.getMessage());
//		}
		// �U�P�W
		// �}�l�ɶ�����p�󵥩��e�ɶ�
		// LocalDate.now(): ���o�t�η�e�ɶ�
		// req.getStartDate().isAfter(LocalDate.now()): �Y req �����}�l�ɶ����e�ɶ��ߡA�|�o�� true
		// !req.getStartDate().isAfter(LocalDate.now()): �e�����[��ĸ��A��ܷ|�o��ۤϪ����G�A�N�O�}�l�ɶ�
		// �|����p���e�ɶ�
		if (req.getStartDate() == null || !req.getStartDate().isAfter(LocalDate.now())) {
			return new BasicRes(ResMessage.PARAM_START_DATE_ERROR.getCode(),
					ResMessage.PARAM_START_DATE_ERROR.getMessage());
		}
		// �{���X�������o��ɡA��ܶ}�l�ɶ��@�w�j�󵥩��e�ɶ�
		// �ҥH�����ˬd�����ɶ��ɡA�u�n�T�w�����ɶ��O�j�󵥩�}�l�ɶ��Y�i�A�]���u�n�����ɶ��O�j�󵥩�}�l�ɶ��A
		// �N�@�w�|�O�j�󵥩��e�ɶ�
		// �}�l�ɶ� >= ��e�ɶ�: �����ɶ� >= �}�l�ɶ� ==> �����ɶ� >= �}�l�ɶ� >= ��e�ɶ�
		// �ҥH���ݭn�P�_ !req.getEndDate().isAfter(LocalDate.now())
		// 1. �����ɶ�����p�󵥩��e�ɶ� 2. �����ɶ�����p��}�l�ɶ�
		if (req.getEndDate() == null || req.getEndDate().isBefore(req.getStartDate())) {
			return new BasicRes(ResMessage.PARAM_END_DATE_ERROR.getCode(),
					ResMessage.PARAM_END_DATE_ERROR.getMessage());
		}
		// �ˬd�Ѽ�
		if (req.getEndDate() == null) {
			return new BasicRes(ResMessage.PARAM_END_DATE_ERROR.getCode(),
					ResMessage.PARAM_END_DATE_ERROR.getMessage());
		}
		// �ˬd���D�Ѽ�
		if (CollectionUtils.isEmpty(req.getQuestionsList())) {
			return new BasicRes(ResMessage.PARAM_QUESTION_LIST_NOT_FOUND.getCode(),
					ResMessage.PARAM_QUESTION_LIST_NOT_FOUND.getMessage());
		}
		for (Question item : req.getQuestionsList()) {
			if (item.getId() <= 0) {
				return new BasicRes(ResMessage.PARAM_QUESTION_ID_ERROR.getCode(),
						ResMessage.PARAM_QUESTION_ID_ERROR.getMessage());
			}
			if (!StringUtils.hasText(item.getTitle())) {
				return new BasicRes(ResMessage.PARAM_TITLE_ERROR.getCode(), ResMessage.PARAM_TITLE_ERROR.getMessage());
			}

			if (!StringUtils.hasText(item.getType())) {
				return new BasicRes(ResMessage.PARAM_TYPE_ID_ERROR.getCode(),
						ResMessage.PARAM_TYPE_ID_ERROR.getMessage());
			}
			// �� option_type �O���Φh��ɡAoptions�N����O�ťզr��
			// �� option_type �O��r�ɡAoptions ���\�O�ťզr��
			// �H�U�����ˬd: �� option_type �O���Φh��ɡA�B�Aoptions �O�ťզr��A��^���~
			if (item.getType().equals(OptionType.SINGLE_CHOICE.getType())//
					|| item.getType().equals(OptionType.MULTIPLE_CHOICE.getType())) {
				if (!StringUtils.hasText(item.getOptions())) {
					return new BasicRes(ResMessage.PARAM_OPTIONS_ERROR.getCode(),
							ResMessage.PARAM_OPTIONS_ERROR.getMessage());
				}
			}
			// �H�U�O�W�z2�� if �X�ּg�k: (����1 || ����2) && ����3
			// �Ĥ@�� if ���� && �ĤG�� if ����
//			if((item.getType().equals(OptionType.SINGLE_CHOICE.getType())
//					|| item.getType().equals(OptionType.MULTI_CHOICE.getType())) 
//					&& !StringUtils.hasText(item.getOptions())) {
//				return new BasicRes(ResMessage.PARAM_OPTIONS_ERROR.getCode(), 
//						ResMessage.PARAM_OPTIONS_ERROR.getMessage());
//			}

		}

		return null;
	}

	@Override
	public SearchRes search(SearchReq req) {
		String name = req.getName();
		LocalDate start = req.getStartDate();
		LocalDate end = req.getEndDate();
		// ���] name�O null �άO���ťժ��r��A�i�H�����S����J��ȡA�N��ܭn���o����
		// JPA �� containing ��k�A����ȬO�Ŧr��ɡA�|�j�M����
		// �ҥH�ݭn�� name ���ȬO null �Υ��ťզr��ɡA�ഫ���Ŧr��
		// �S������ȮɡA�|�j�M����
		if (!StringUtils.hasText(name)) {
			name = "";
		}
		if (start == null) {
			start = LocalDate.of(1970, 1, 1);
		}
		if (end == null) {
			end = LocalDate.of(2999, 12, 31); // 2999-12-31 23:59:59();
		}
//		List<Quiz> res = quizDao.findByNameContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(name, 
//				start, end);
//		return new SearchRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(), res);
		return new SearchRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage(),
				quizDao.findByNameContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(name, //
						start, end)); // Containing �ҽk�j�M
	}

	@Override
	public BasicRes delete(DeleteReq req) {
		// �ˬd�Ѽ�
		// List �O���X���@�ءA�ҥH�n�� CollectionUtils
		if (!CollectionUtils.isEmpty(req.getIdList())) {
			// �R���ݨ�
			try {
				quizDao.deleteAllById(req.getIdList());
			} catch (Exception e) {
				// �� deleteAllById ��k���Aid ���Ȥ��s�b�ɡAJPA �|����
				// �]���b�R�����e�AJPA �|���j�M�a�J�� id �ȡA�Y�S���G�N�|����
				// �ѩ��ڤW�S�R�������ơA�]���N���ݭn��o�� Exception �@�B�z
			}
		}
		return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
	}

//	@Override
//	public BasicRes fillin(FillinReq req) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
