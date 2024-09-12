package com.example.day15template.dto;


import com.example.day15template.pojo.Setmeal;
import com.example.day15template.pojo.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
