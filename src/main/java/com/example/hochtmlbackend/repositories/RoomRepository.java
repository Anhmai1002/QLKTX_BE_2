package com.example.hochtmlbackend.repositories;

import com.example.hochtmlbackend.entities.Room;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room, ObjectId> {
    Room findByRoomId(String roomId);

}
