package top.example.boot.config.Controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.example.boot.config.model.Team;

/**
 * @Author: wujiawang
 * @Date: 2025/9/11
 * @Version: 1.0
 */
@RestController
public class TeamController {
    @PostMapping("/team")
    public ResponseEntity<Team> addTeam(@Valid @RequestBody Team team){
        return ResponseEntity.ok(team);
    }
}
