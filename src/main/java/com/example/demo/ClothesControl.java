package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClothesControl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addClothes(Clothes clothes) {
        String sql = "INSERT INTO clothes (name, color, brand, size, price, quantity) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, clothes.getName(), clothes.getColor(), clothes.getBrand(), clothes.getSize(),
        clothes.getPrice(), clothes.getQuantity());
    }

    public List<Clothes> getAllClothes() {
        String sql = "SELECT * FROM clothes";
        return jdbcTemplate.query(sql, new ClothesRowMapper());
    }

    public void updateClothes(Integer id, Clothes updatedClothes) {
        String sql = "UPDATE clothes SET name=?, color=?, brand=?, size=?, price=?, quantity=? WHERE id=?";
        jdbcTemplate.update(sql, updatedClothes.getName(),updatedClothes.getColor(), updatedClothes.getBrand(),
                updatedClothes.getSize(), updatedClothes.getPrice(), updatedClothes.getQuantity(), id);
    }

    public void deleteClothes(Integer id) {
        String sql = "DELETE FROM clothes WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public List<Clothes> searchClothes(String field, String value) {
        String sql = "SELECT * FROM clothes WHERE LOWER(" + field + ") LIKE ?";
        return jdbcTemplate.query(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + value.toLowerCase() + "%");
            return ps;
        }, new ClothesRowMapper());
    }

    private static class ClothesRowMapper implements RowMapper<Clothes> {
        @Override
        public Clothes mapRow(ResultSet rs, int rowNum) throws SQLException {
            Clothes clothes = new Clothes();
            clothes.setId(rs.getInt("id"));
            clothes.setName(rs.getString("item_name"));
            clothes.setColor(rs.getString("color"));
            clothes.setBrand(rs.getString("brand"));
            clothes.setSize(rs.getInt("item_size"));
            clothes.setPrice(rs.getDouble("price"));
            clothes.setQuantity(rs.getInt("quantity"));
            return clothes;
        }
    }
}
