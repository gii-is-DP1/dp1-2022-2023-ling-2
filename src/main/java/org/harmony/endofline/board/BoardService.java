package org.harmony.endofline.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepo;

    public Optional<Board> findById(Integer id){
        return boardRepo.findById(id);
    }
}
