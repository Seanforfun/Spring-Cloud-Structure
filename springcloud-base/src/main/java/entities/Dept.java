package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: Seanforfun
 * @date: Created in 2019/7/8 14:56
 * @description: ${description}
 * @modified:
 * @version: 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept {
    private String deptName;
    private long deptId;
    private String db_source;
}
