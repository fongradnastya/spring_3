package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClothesService {
    @Autowired
    private ClothesControl clothesControl;

    public void addClothes(Clothes clothes) {
        clothesControl.addClothes(clothes);
    }

    /**
     * Возвращает список всех мебельных предметов из базы данных.
     * @return список мебели.
     */
    public List<Clothes> getAllClothes() {
        return clothesControl.getAllClothes();
    }

    public void updateClothes(Integer id, Clothes updatedClothes) {
        clothesControl.updateClothes(id, updatedClothes);
    }

    /**
     * Удаляет мебель из базы данных по идентификатору.
     * @param id идентификатор мебели для удаления.
     */
    public void deleteClothes(Integer id) {
        clothesControl.deleteClothes(id);
    }

    /**
     * Осуществляет поиск мебели по заданному полю и значению.
     * @param field поле для поиска.
     * @param value значение для поиска.
     * @return список мебели, соответствующий критериям поиска.
     */
    public List<Clothes> searchClothes(String field, String value) {
        return clothesControl.searchClothes(field, value);
    }
}
