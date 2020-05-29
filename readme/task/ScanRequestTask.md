# ScanRequestTask.java

Peripheral Scan Request

分机扫描添加请求

## ScanRequestTask
| Return <br/> 返回 | Method <br/> 方法 | 
| - | - |
| AsyncTask | <br/> `ScanRequestTask`(Activity activity, [ScanRequestTask.Callback](#ScanRequestTask.Callback) callback) <br/><br/> Peripheral Scan Request <br/> activity: Activity <br/> callback: Callback <br/><br/> 分机扫描添加请求 <br/> activity: 活动 <br/> callback: 回调处理 |

## ScanRequestTask.Callback
| Return <br/> 返回 | Method <br/> 方法 | 
| - | - |
| void | <br/> `onResponse`([StatusType](../define/StatusType.md) status, byte peripheralId, [PeripheralType](../define/PeripheralType.md) peripheralType) <br/><br/> On Response <br/> status: Status <br/> peripheralId: Peripheral ID <br/> peripheralType: Peripheral Type <br/><br/> 请求回调 <br/> status: 回复状态 <br/> peripheralId: 分机 ID <br/> peripheralType: 分机类型 |
