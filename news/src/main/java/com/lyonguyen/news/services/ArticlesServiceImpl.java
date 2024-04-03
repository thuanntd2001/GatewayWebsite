package com.lyonguyen.news.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyonguyen.news.exceptions.BadRequestException;
import com.lyonguyen.news.exceptions.NotFoundException;
import com.lyonguyen.news.models.Article;
import com.lyonguyen.news.repositories.ArticlesRepository;

@Service
@Transactional
public class ArticlesServiceImpl implements ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

    public Article get(Long id) {
        Optional<Article> maybeArticle = articlesRepository.findById(id);

        if (!maybeArticle.isPresent()) {
            throw new NotFoundException();
        }

        return maybeArticle.get();
    }

    @Override
    public Article create(Article article) {
        if (article.getId() != null) {
            throw new BadRequestException();
        }

        return articlesRepository.save(article);
    }

    @Override
    public Article update(Article article) {
        if (article.getId() == null) {
            throw new BadRequestException();
        }
        if (!articlesRepository.existsById(article.getId())) {
            throw new NotFoundException();
        }
        if (article.getImage() == null || article.getImage().strip() == "")
        {
        	article.setImage(articlesRepository.findById(article.getId()).get().getImage());
        }

        return articlesRepository.save(article);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new BadRequestException();
        }
        if (!articlesRepository.existsById(id)) {
            throw new NotFoundException();
        }

        articlesRepository.deleteById(id);
    }
}
