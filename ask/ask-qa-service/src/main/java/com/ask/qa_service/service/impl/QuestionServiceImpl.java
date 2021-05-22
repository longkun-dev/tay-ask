package com.ask.qa_service.service.impl;

import com.ask.qa_service.common.RequestUtils;
import com.ask.qa_service.common.UUIDUtils;
import com.ask.qa_service.constant.Constant;
import com.ask.qa_service.dao.AskQuestionContentDao;
import com.ask.qa_service.dao.AskQuestionDao;
import com.ask.qa_service.dao.CommonCodeDao;
import com.ask.qa_service.entity.po.AskQuestionContentPo;
import com.ask.qa_service.entity.po.AskQuestionPo;
import com.ask.qa_service.entity.po.CommonCodePo;
import com.ask.qa_service.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhulongkun20@163.com
 * @since 2021/4/30 11:23 PM
 */
@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private AskQuestionDao questionDao;

    @Autowired
    private CommonCodeDao codeDao;

    @Autowired
    private AskQuestionContentDao questionContentDao;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @Transactional
    @Override
    public String newQuestion(AskQuestionPo questionPo) {
        if (questionPo == null || StringUtils.isEmpty(questionPo.getQuestionTitle())
                || StringUtils.isEmpty(questionPo.getQuestionContent())) {
            return "问题发布失败，问题标题和问题内容不能为空";
        }

        String currentUserId = RequestUtils.getCurrentUserId();

        questionPo.setId(UUIDUtils.randomUUID36());
        questionPo.setQuestionNo(generateQuestionNo());
        questionPo.setPublishTime(new Date());
        questionPo.setVotes(0);
        questionPo.setAnswers(0);
        questionPo.setViews(0);
        questionPo.setAskedBy(currentUserId);
        questionPo.setCreatedBy(currentUserId);
        questionPo.setUpdatedBy(currentUserId);

        questionDao.insert(questionPo);

        AskQuestionContentPo questionContentPo = new AskQuestionContentPo();
        questionContentPo.setId(UUIDUtils.randomUUID36());
        questionContentPo.setQuestionNo(questionPo.getQuestionNo());
        questionContentPo.setQuestionContent(questionPo.getQuestionContent());
        questionContentPo.setCreatedBy(currentUserId);
        questionContentPo.setUpdatedBy(currentUserId);
        questionContentDao.insert(questionContentPo);

        // 保存问题标签
        storeQuestionTag(questionPo);

        return "问题已成功发布";
    }

    /**
     * 生成问题编号
     *
     * @return 一个可用的问题编号
     */
    @Override
    public String generateQuestionNo() {
        String newQuestionNo;
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.DATE_FORMAT_yyyyMMdd);
        String prefix = Constant.QUESTION_ID_PREFIX + dateFormat.format(new Date());
        String currentUserId = RequestUtils.getCurrentUserId();
        List<CommonCodePo> codePoList = codeDao.selectByCodeName(Constant.LATEST_QUESTION_ID);
        CommonCodePo codePo;
        if (CollectionUtils.isNotEmpty(codePoList)) {
            codePo = codePoList.get(0);
            String codePrefix = codePo.getCodeValue().substring(0, 9);
            if (Objects.equals(prefix, codePrefix)) {
                String baseNum = codePo.getCodeValue().substring(9);
                String newNum = StringUtils.leftPad(String.valueOf(Integer.parseInt(baseNum) + 1), 6,
                        '0');
                newQuestionNo = codePo.getCodeValue().substring(0, 9) + newNum;
            } else {
                newQuestionNo = prefix + Constant.QUESTION_ID_START;
            }
            codePo.setCodeValue(newQuestionNo);
            codePo.setRemark("最近生成的问题编号");
            codePo.setUpdatedBy(currentUserId);
            codeDao.updateCodeValueByCodeName(codePo);
        } else {
            newQuestionNo = Constant.QUESTION_ID_PREFIX + dateFormat.format(new Date())
                    + Constant.QUESTION_ID_START;
            codePo = new CommonCodePo();
            codePo.setId(UUIDUtils.randomUUID36());
            codePo.setCodeName(Constant.LATEST_QUESTION_ID);
            codePo.setCodeValue(newQuestionNo);
            codePo.setRemark("最近生成的问题编号");
            codePo.setCreatedBy(currentUserId);
            codePo.setUpdatedBy(currentUserId);
            codeDao.insert(codePo);
        }

        return newQuestionNo;
    }

    /**
     * 创建问题时保存相应的标签
     *
     * @param questionPo 问题实体类
     */
    private void storeQuestionTag(AskQuestionPo questionPo) {
        String tags = questionPo.getTags();
        // isBlank空白字符也会判定为空，推荐使用
        if (StringUtils.isBlank(tags)) {
            return;
        }

        List<String> tagList = new ArrayList<>(Arrays.asList(tags.split(";")));
        tagList = tagList.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(tagList)) {
            return;
        }

        List<CommonCodePo> existTagList = codeDao.selectByCodeName(Constant.QUESTION_TAG);
        if (CollectionUtils.isNotEmpty(existTagList)) {
            List<String> existTagNameList = existTagList.stream().map(CommonCodePo::getCodeValue)
                    .collect(Collectors.toList());
            // 筛选出在库中不存在标签
            tagList = tagList.stream().filter(e -> !existTagNameList.contains(e)).collect(Collectors.toList());
        }

        CommonCodePo codePo;
        String currentUserId = RequestUtils.getCurrentUserId();
        List<CommonCodePo> codePoList = new ArrayList<>(tagList.size());
        for (String tag : tagList) {
            codePo = new CommonCodePo();
            codePo.setId(UUIDUtils.randomUUID36());
            codePo.setCodeName(Constant.QUESTION_TAG);
            codePo.setCodeValue(tag);
            codePo.setRemark("问题标签");
            codePo.setCreatedBy(currentUserId);
            codePo.setUpdatedBy(currentUserId);
            codePoList.add(codePo);
        }

        if (CollectionUtils.isNotEmpty(codePoList)) {
            codeDao.insertBatch(codePoList);
        }
    }

    @Override
    public AskQuestionPo getQuestion(String questionNo) {
        if (StringUtils.isEmpty(questionNo)) {
            return null;
        }
        return questionDao.selectByQuestionNo(questionNo);
    }

    @Override
    public int deleteQuestion(String questionNo) {
        if (StringUtils.isEmpty(questionNo)) {
            return 0;
        }
        return questionDao.deleteByQuestionNo(questionNo);
    }

    @Override
    public List<AskQuestionPo> listRandomQuestions(int count) {
        if (count <= 0) {
            count = Constant.RANDOM_QUESTION_COUNT;
        }

        return questionDao.selectByCount(count);
    }

    @Override
    public List<AskQuestionPo> listTopQuestions(int count) {
        if (count <= 0) {
            count = Constant.TOP_QUESTION_COUNT;
        }
        return questionDao.selectQuestionByCreateTime(count);
    }

    @Override
    public Integer getQuestionCount() {
        return questionDao.selectCount();
    }
}
