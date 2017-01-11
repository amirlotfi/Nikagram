
package ir.nikagram.tgnet;

public interface FileLoadOperationDelegate {
    void onFinished(String path);
    void onFailed(int reason);
    void onProgressChanged(float progress);
}
