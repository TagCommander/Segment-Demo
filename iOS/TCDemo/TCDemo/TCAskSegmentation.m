#import "TCAskSegmentation.h"
#import <TCSegment/TCSegmentConstants.h>
#import <TCSegment/TCSegmentation.h>

@implementation TCAskSegmentation

- (IBAction) askSegment: (UISlider *) sender
{
    [[TCSegmentation sharedInstance] setSiteID: 3311 andToken: kTCS_token];
    [[TCSegmentation sharedInstance] fetchSegment];
    NSArray *segments = [[TCSegmentation sharedInstance] getSegments];
    
    if ([segments count] > 0)
    {
        [self.segmentList setText: [NSString stringWithFormat: @"Segment list : %@", segments]];
    }
    else
    {
        [self.segmentList setText: @"No segments found yet"];
    }
}

@end
