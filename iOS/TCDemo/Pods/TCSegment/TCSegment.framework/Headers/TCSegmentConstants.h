//
// Created by JeanJulien on 04/11/2016.
// Copyright (c) 2016 TagCommander. All rights reserved.
//

#import <Foundation/Foundation.h>

#ifndef TagCommander_TCSegmentationConstants_h
#define TagCommander_TCSegmentationConstants_h

@interface TCSegmentConstants : NSObject

#pragma mark - misc
extern NSString *const kTCS_LastKnownSegments;
extern NSString *const kTCS_apiURL;
extern NSString *const kTCS_token;

#pragma mark - Notification
extern NSString *const kTCNotification_SegmentAvailable;

#pragma mark - notification userInfo
extern NSString *const kTCUserInfo_SegmentKey;

@end

#endif
