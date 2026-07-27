package com.vlineup.service;

public interface CollectAndLikeService {
    Boolean isAlreadyCollect(String username, String uuid);

    void saveCollect(String username, String uuid);

    void removeCollect(String username, String uuid);
}
