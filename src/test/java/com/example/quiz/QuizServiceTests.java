package com.example.quiz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.quiz.constants.OptionType;
import com.example.quiz.repository.QuizDao;
import com.example.quiz.service.ifs.QuizService;
import com.example.quiz.vo.BasicRes;
import com.example.quiz.vo.CreateOrUpdateReq;
import com.example.quiz.vo.Question;

// �椸���աA�����޿�
@SpringBootTest
public class QuizServiceTests {

	@Autowired
	private QuizService quizService;

	@Autowired
	private QuizDao quizDao;

	@Test
	public void createTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "���d�\?", "�Q���ޡF���ޱơF�γ��F�N���L", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(2, "����", "1���\�F2���\�F3���\�F4���\", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(3, "����", "�ަת����F���A�����F�z�����a��(��)�F��X����", //
				OptionType.SINGLE_CHOICE.getType(), true));
		CreateOrUpdateReq req = new CreateOrUpdateReq("���\�Yԣ?", "���\�Y����O?", LocalDate.of(2024, 6, 2), //
				LocalDate.of(2024, 6, 1), questionList, true);//
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test failed!!");
		// �R�����ո�� TODO
	}

	@Test
	public void createNameErrorTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "���d�\?", "�Q���ޡF���ޱơF�γ��F�N���L", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(2, "����", "1���\�F2���\�F3���\�F4���\", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(3, "����", "�ަת����F���A�����F�z�����a��(��)�F��X����", //
				OptionType.SINGLE_CHOICE.getType(), true));
		CreateOrUpdateReq req = new CreateOrUpdateReq("", "���\�Y����O?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);//
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param name error!!"), "create test failed!!");
		// �R�����ո�� TODO
	}

	@Test
	public void createStartDateErrorTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "���d�\?", "�Q���ޡF���ޱơF�γ��F�N���L", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(2, "����", "1���\�F2���\�F3���\�F4���\", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(3, "����", "�ަת����F���A�����F�z�����a��(��)�F��X����", //
				OptionType.SINGLE_CHOICE.getType(), true));
		// ���ѬO 2024/5/30�A�ҥH�}�l�ɶ�����O��ѩάO���e
		CreateOrUpdateReq req = new CreateOrUpdateReq("���\�Yԣ?", "���\�Y����O?", LocalDate.of(2024, 5, 30), //
				LocalDate.of(2024, 6, 1), questionList, true);//
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param start date error!!"), "create test failed!!");
		// �R�����ո�� TODO
	}
	
	//���󧹾㪺����
	@Test
	public void createTest1() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "���d�\?", "�Q���ޡF���ޱơF�γ��F�N���L", //
				OptionType.SINGLE_CHOICE.getType(), true));
		// ���� name error
		CreateOrUpdateReq req = new CreateOrUpdateReq("", "���\�Y����O?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);//
		BasicRes res = quizService.createOrUpdate(req);
		// res.getMessage().equalsIgnoreCase("Param name error!!")���զ��\�|�Ǧ^ "Param name error!!"�A���|����
		// �p�G���ե��ѷ|�Ǧ^ "create test failed!!"
		// �����j�p�g equalsIgnoreCase�A���|�����Ӧr�ꪺ���e
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param name error!!"), "create test failed!!");
		// ���� start date error: ���]���ѬO 2024/5/30�A�ҥH�}�l�ɶ�����O��ѩάO���e
		req = new CreateOrUpdateReq("���\�Yԣ?", "���\�Y����O?", LocalDate.of(2024, 5, 30), //
				LocalDate.of(2024, 6, 1), questionList, true);//
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param start date error!!"), "create test failed!!");
		// ���� end date error: ������������}�l�����
		req = new CreateOrUpdateReq("���\�Yԣ?", "���\�Y����O?", LocalDate.of(2024, 6, 30), //
				LocalDate.of(2024, 6, 1), questionList, true);//
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param end date error!!"), "create test failed!!");
		// �Ѿl���޿�����P�_������A�̫�~�|�O���զ��\������
		req = new CreateOrUpdateReq("���\�Yԣ?", "���\�Y����O?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);//
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test failed!!");
	}
}
