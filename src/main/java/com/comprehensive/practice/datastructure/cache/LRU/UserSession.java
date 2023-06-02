package com.comprehensive.practice.datastructure.cache.LRU;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
public class UserSession {
   private UUID userSession;
   private LocalDateTime StartTime;
   private LocalDateTime endTime;
   private Long inactiveInterval;
   private String name;

}
