#import "TCAskSegmentation.h"
#import <TCSegment/TCSegmentConstants.h>
#import <TCSegment/TCSegmentation.h>

@implementation TCAskSegmentation

- (IBAction) askSegment: (UISlider *) sender
{
    [[TCSegmentation sharedInstance] fetchSegment];

    NSNotificationCenter *notificationCenter = [NSNotificationCenter defaultCenter];
    [notificationCenter addObserver: self
                           selector: (@selector(onNotification:))
                               name: kTCNotification_SegmentAvailable
                             object: nil];
}

- (void) onNotification: (NSNotification *) incomingNotification
{
    NSString *name = incomingNotification.name;
    if ([name isEqualToString: kTCNotification_SegmentAvailable])
    {
        NSArray *segment = incomingNotification.userInfo[kTCUserInfo_SegmentKey];

        dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0), ^{
            //do stuff in background
            dispatch_async(dispatch_get_main_queue(), ^{
                self.segmentList.text = [NSString stringWithFormat: @"Segment list : %@", segment];
            });
            
        });
        
    }
}

@end
