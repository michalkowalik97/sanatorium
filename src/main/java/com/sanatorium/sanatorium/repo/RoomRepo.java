package com.sanatorium.sanatorium.repo;

import com.sanatorium.sanatorium.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, Integer> {
}
